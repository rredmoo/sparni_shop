import React, { useEffect, useState } from "react";
import Header from "./common/Header";
import JaunumuPageConfig from "../config/JaunumuPageConfig";
import Pasakums from "./jaunumuPage/pasakums";

function EventsPage() {
  const [error, setError] = useState(null);

  return (
    <>
      <Header />
      <h1>Jaunumi</h1>
      <Pasakums /> 

      {error && <p>Error: {error}</p>}
    </>
  );
}

export default EventsPage;
