import React, { useState, useEffect } from "react";
import { loadStripe } from "@stripe/stripe-js";
import { Elements } from "@stripe/react-stripe-js";
import PaymentForm from "./PaymentForm";
import axios from "axios";
import "./ShoppingCart.css";
import Header from "../common/Header";
import Footer from "../common/Footer";

const stripePromise = loadStripe(
  "pk_test_51EAiktBEaidOzrZmREXHQxQAD1jHeOXWgXKRijDq2poLuErrHrVs3Mzs2W93F3WZPLzqXIX3xxcwhyjRRShxtBqa00ZpUCXL3h"
);

function ShoppingCart() {
  const [clientSecret, setClientSecret] = useState("");
  const [amount, setAmount] = useState(0);
  const [basketItems, setBasketItems] = useState([]);
  const [showPayment, setShowPayment] = useState(false);

  useEffect(() => {
    fetchBasketItems();
  }, []);

  const fetchBasketItems = async () => {
    try {
      const response = await axios.get("http://localhost:8080/basket/item/all");
      setBasketItems(response.data);
      updateTotalAmount(response.data);
    } catch (error) {
      console.error("Error fetching basket items:", error);
    }
  };

  const updateTotalAmount = (items) => {
    const totalAmount = items.reduce(
      (total, item) => total + item.product.cena * item.count,
      0
    );
    setAmount(totalAmount * 100);
  };

  const updateItemCount = async (id, newCount) => {
    if (newCount < 1) return;

    try {
      await axios.put(`http://localhost:8080/basket/item/update/${id}`, {
        count: newCount,
      });

      const updatedItems = basketItems.map((item) =>
        item.id === id ? { ...item, count: newCount } : item
      );
      setBasketItems(updatedItems);
      updateTotalAmount(updatedItems);
    } catch (error) {
      console.error("Error updating item count:", error);
    }
  };

  const removeItem = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/basket/item/remove/${id}`);

      const updatedItems = basketItems.filter((item) => item.id !== id);
      setBasketItems(updatedItems);
      updateTotalAmount(updatedItems);
    } catch (error) {
      console.error("Error removing item:", error);
    }
  };

  const handleBuyClick = async () => {
    console.log("Pirkt button clicked with amount:", amount);

    if (amount <= 0) {
      console.error("Invalid amount:", amount);
      return;
    }

    try {
      const response = await axios.post("http://localhost:8080/payment/create", { amount });
      console.log("Payment intent response:", response.data);

      if (response.data.clientSecret) {
        setClientSecret(response.data.clientSecret);
        setShowPayment(true);
      } else {
        console.error("No clientSecret received from backend.");
      }
    } catch (error) {
      console.error("Error creating payment intent:", error);
    }
  };

  return (
    <>
      <Header />
      <div className="shopping-cart-container">
        <div className="cart-container">
          <div className="cart-items">
            <h2>Jūsu grozs</h2>
            <br />
            {basketItems.length === 0 ? (
              <p>Your basket is empty.</p>
            ) : (
              <ul>
                {basketItems.map((item) => (
                  <li key={item.id} className="cart-item">
                    <img
                      src={item.product.veikals_prece_bildes}
                      alt={item.product.nosaukums}
                    />
                    <span>
                      {item.product.nosaukums} - {item.count} x {item.product.cena}€
                    </span>

                    <div className="quantity-controls">
                      <button
                        className="cart-edit-button"
                        onClick={() => updateItemCount(item.id, item.count + 1)}
                      >
                        ▲
                      </button>
                      <span>{item.count}</span>
                      <button
                        className="cart-edit-button"
                        onClick={() => updateItemCount(item.id, item.count - 1)}
                      >
                        ▼
                      </button>
                    </div>

                    <button className="remove-button" onClick={() => removeItem(item.id)}>
                      ❌
                    </button>
                  </li>
                ))}
              </ul>
            )}
          </div>

          <div className="cart-summary">
            <h2 className="h2Cart">Grozs kopsavilkums</h2>
            <div className="total-price">
              <strong>Total: {(amount / 100).toFixed(2)}€</strong>
            </div>

            <button className="buy-button" onClick={handleBuyClick}>
              Pirkt
            </button>

            {showPayment && (
              <div className="payment-form">
                <h2>Maksājumu sistēma</h2>
                <label htmlFor="amount">Ievadiet summu (centos): </label>
                <input
                  type="number"
                  id="amount"
                  value={amount}
                  onChange={(e) => setAmount(Number(e.target.value))}
                  min="1"
                  step="1"
                />
                <br />

                {clientSecret && (
                  <Elements stripe={stripePromise}>
                    <PaymentForm clientSecret={clientSecret} />
                  </Elements>
                )}
              </div>
            )}
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
}

export default ShoppingCart;
