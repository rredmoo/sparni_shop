import React, { useState } from "react";
import { useStripe, useElements, CardElement } from "@stripe/react-stripe-js";

const PaymentForm = ({ clientSecret }) => {
  const [paymentStatus, setPaymentStatus] = useState("");
  const [paymentIntentId, setPaymentIntentId] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const stripe = useStripe();
  const elements = useElements();

  const handleSubmit = async (event) => {
    event.preventDefault();
    if (!stripe || !elements) {
      return;
    }

    const cardElement = elements.getElement(CardElement);

    // Perform validation for name and email
    if (!name || !email) {
      alert("Please enter your name and email!");
      return;
    }

    const { error, paymentIntent } = await stripe.confirmCardPayment(
      clientSecret,
      {
        payment_method: {
          card: cardElement,
          billing_details: {
            name: name,
            email: email,
          },
        },
      }
    );

    if (error) {
      console.error("Payment error:", error.message);
    } else {
      setPaymentIntentId(paymentIntent.id);
      setPaymentStatus(paymentIntent.status);
      await sendPaymentDataToBackend(paymentIntent.id, paymentIntent.status);

      if (paymentIntent.status === "succeeded") {
        await sendPaymentDataToBackend(paymentIntent.id, paymentIntent.status, name, email);
        // Display success notification
        if (Notification.permission === "granted") {
          new Notification("Order Completed", {
            body: `Payment Status: succeeded`,
          });
        } else {
          // Request permission for notifications if not granted
          Notification.requestPermission().then((permission) => {
            if (permission === "granted") {
              new Notification("Order Completed", {
                body: `Payment Status: succeeded`,
              });
            }
          });
        }
      }
    }
  };

  const sendPaymentDataToBackend = async (paymentIntentId, paymentStatus, name, email) => {
    const response = await fetch("http://localhost:8080/payment/confirm", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        paymentIntentId: paymentIntentId,
        paymentStatus: paymentStatus,
        name: name,
        email: email,
      }),
    });
    if (response.ok) {
      console.log("Data successfully sent to the backend!");
    } else {
      console.error("Failed to send data to the backend");
    }
  };
  

  return (
    <div>
      <form onSubmit={handleSubmit} className="payment-form">
        <div>
          <label htmlFor="name">Name</label>
          <input
            type="text"
            id="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="email">Email</label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <CardElement />
        <button type="submit" disabled={!stripe}>
          Pay
        </button>
      </form>
      <div>{paymentStatus && `Payment status: ${paymentStatus}`}</div>
      {/* <div>{paymentIntentId && `Payment ID: ${paymentIntentId}`}</div> */}
    </div>
  );
};

export default PaymentForm;
