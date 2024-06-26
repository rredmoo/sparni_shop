import React, { useEffect, useState } from "react";
import Header from "./common/Header";


function MainPage() {
  const [error, setError] = useState(null);

  return (
    <>
      <Header />
      <h1>Par mums</h1>
      

      {error && <p>Error: {error}</p>}
    </>
  );
}

export default MainPage;
