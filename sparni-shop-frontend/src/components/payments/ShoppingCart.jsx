import React, { useState } from "react";
import { loadStripe } from "@stripe/stripe-js";
import { Elements } from "@stripe/react-stripe-js";
import PaymentForm from "./PaymentForm";

// Load Stripe public key
const stripePromise = loadStripe("pk_test_51EAiktBEaidOzrZmREXHQxQAD1jHeOXWgXKRijDq2poLuErrHrVs3Mzs2W93F3WZPLzqXIX3xxcwhyjRRShxtBqa00ZpUCXL3h");

function ShoppingCart() {
  const [clientSecret, setClientSecret] = useState("");
  const [amount, setAmount] = useState(5000);
  const createPaymentIntent = async (amount) => {
    const response = await fetch("http://localhost:8080/payment/create", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        amount: amount,
        currency: "eur",
      }),
    });
    const data = await response.json();
    setClientSecret(data.clientSecret);
  };
  const handleBuyClick = () => {
    createPaymentIntent(amount);
  };
  return (
    <div className="ShoppingCartContainer">
      <h1>Maksājumu sistēma</h1>
      <label htmlFor="amount">Ievadiet summu (centos): </label>
      <input
        type="number"
        id="amount"
        value={amount}
        onChange={(e) => setAmount(e.target.value)}
        min="1"
        step="1"
      />
      <br />
      <button onClick={handleBuyClick}>Pirkt</button>
      <br />
      {clientSecret && (
        <Elements stripe={stripePromise}>
          <PaymentForm clientSecret={clientSecret} />
        </Elements>
      )}
    </div>
  );
}
export default ShoppingCart;
