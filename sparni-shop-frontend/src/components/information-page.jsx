import React, { useEffect, useState } from "react";
import Header from "./common/Header";


function InformationPage() {
  const [error, setError] = useState(null);

  return (
    <>
      <Header />
      <h1>Informācija</h1>
      

      {error && <p>Error: {error}</p>}
    </>
  );
}

export default InformationPage;
