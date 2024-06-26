import React, { useEffect, useState } from "react";
import Header from "./common/Header";


function ContactsPage() {
  const [error, setError] = useState(null);

  return (
    <>
      <Header />
      <h1>Kontakti</h1>
      

      {error && <p>Error: {error}</p>}
    </>
  );
}

export default ContactsPage;
