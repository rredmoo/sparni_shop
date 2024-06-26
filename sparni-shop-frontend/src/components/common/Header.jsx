import React from 'react';
import { Link } from 'react-router-dom';
import '../../static/css/Header.css';

function Header() {
  return (
    <header className="allnav">
      <nav>
        <Link to="/main">Sākums</Link>
        <Link to="/store">Veikals</Link>
        <Link to="/events">Jaunumi</Link>
        <Link to="/info">Informācija</Link>
        <Link to="/contact">Kontakti</Link>
      </nav>
      <hr />
    </header>
  );
}

export default Header;
