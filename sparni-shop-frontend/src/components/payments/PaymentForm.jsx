import React, { useState } from "react";
import { useStripe, useElements, CardElement } from "@stripe/react-stripe-js";
const PaymentForm = ({ clientSecret }) => {
  const [paymentStatus, setPaymentStatus] = useState("");
  const [paymentIntentId, setPaymentIntentId] = useState("");
  const stripe = useStripe();
  const elements = useElements();
  const handleSubmit = async (event) => {
    event.preventDefault();
    if (!stripe || !elements) {
      return;
    }
    const cardElement = elements.getElement(CardElement);
    const { error, paymentIntent } = await stripe.confirmCardPayment(
      clientSecret,
      {
        payment_method: {
          card: cardElement,
        },
      }
    );
    if (error) {
      console.error("Maksājuma kļūda:", error.message);
    } else {
      setPaymentIntentId(paymentIntent.id);
      setPaymentStatus(paymentIntent.status);
      await sendPaymentDataToBackend(paymentIntent.id, paymentIntent.status);
    }
  };
  const sendPaymentDataToBackend = async (paymentIntentId, paymentStatus) => {
    const response = await fetch("http://localhost:8080/payment/confirm", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        paymentIntentId: paymentIntentId,
        paymentStatus: paymentStatus,
      }),
    });
    if (response.ok) {
      console.log("Dati veiksmīgi nosūtīti uz serveri!");
    } else {
      console.error("Neizdevās nosūtīt datus uz serveri");
    }
  };
  return (
    <div>
      <form onSubmit={handleSubmit}>
        <CardElement />
        <button type="submit" disabled={!stripe}>
          Maksāt
        </button>
      </form>
      <div>{paymentStatus && `Maksājuma statuss: ${paymentStatus}`}</div>
      <div>{paymentIntentId && `Maksājuma ID: ${paymentIntentId}`}</div>
    </div>
  );
};
export default PaymentForm;
