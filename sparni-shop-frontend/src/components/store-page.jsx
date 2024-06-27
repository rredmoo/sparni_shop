import React, { useState } from "react";
import Header from "./common/Header";
import Product from "./veikalsPage/product";

function StorePage() {
  const [error, setError] = useState(null);
  const [sortOrder, setSortOrder] = useState(null);

  const handleSortOrder = (order) => {
    setSortOrder(order);
  };

  return (
    <>
      <Header />
      <h1>Šobrīd pieejamās preces</h1>
      <div>
        <button onClick={() => handleSortOrder('asc')}>Sort ASC</button>
        <button onClick={() => handleSortOrder('desc')}>Sort DESC</button>
      </div>
      <Product sortOrder={sortOrder} />

      {error && <p>Error: {error}</p>}
    </>
  );
}

export default StorePage;
