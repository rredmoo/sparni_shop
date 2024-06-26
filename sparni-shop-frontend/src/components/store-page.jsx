import React, { useEffect, useState } from "react";
import PrecesServiceConfig from "../config/VeikalsPageConfig";
import Header from "./common/Header";
import Product from "./veikalsPage/product";

function StorePage() {
  const [error, setError] = useState(null);

  return (
    <>
      <Header />
      <h1>Pašlaik pieejamās preces</h1>

      <Product />

      {error && <p>Error: {error}</p>}
    </>
  );
}

export default StorePage;
