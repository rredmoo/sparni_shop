import "../../static/css/Footer.css";
import { Link } from "react-router-dom";

function Footer() {
  return (
    <>
      <footer>
        <div className="container">
          <nav>
            <Link to="/main">Sākums</Link>
            <Link to="/store">Veikals</Link>
            <Link to="/events">Jaunumi</Link>
            <Link to="/info">Informācija</Link>
            <Link to="/contact">Kontakti</Link>
          </nav>
          <hr />
          <p className="note">
            # kontakti
          </p>
        </div>
      </footer>
    </>
  );
}

export default Footer;
