import React, { useEffect, useState } from "react";
import Header from "./common/Header";
import InformacijasPageConfig from "../config/InformacijasPageConfig";
import Informacija from "./informacijasPage/informacija";

function InformacijasPage() {
  const [error, setError] = useState(null);

  return (
    <>
      <Header />
      <h1>Informācija</h1>
      <Informacija /> 

      {error && <p>Error: {error}</p>}
    </>
  );
}

export default InformacijasPage;
