import React, { useEffect, useState } from "react";
import Header from "./common/Header";
import KontaktiPageConfig from "../config/KontaktiPageConfig";
import KontaktiPage from "./kontaktiPage/kontakti";


function KontaktiSave() {
  const [error, setError] = useState(null);

  return (
    <>
      <Header />
      <h1>Kontakti</h1>

      <KontaktiPage />

      {error && <p>Error: {error}</p>}
    </>
  );
}

export default KontaktiSave;
