import React, { useEffect, useState } from "react";
import Header from "./common/Header";


function EventsPage() {
  const [error, setError] = useState(null);

  return (
    <>
      <Header />
      <h1>Jaunumi</h1>
      

      {error && <p>Error: {error}</p>}
    </>
  );
}

export default EventsPage;
