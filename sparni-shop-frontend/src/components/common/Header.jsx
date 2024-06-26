import "../../static/css/Header.css";

function Header() {
    return (
        <header className="allnav">
            <nav>
                <a href="#mainPage">Sākums</a>
                <a href="#store">Veikals</a>
                <a href="#events">Pasākumi</a>
                <a href="#information">Informācija</a>
                <a href="#contacts">Kontakti</a>
            </nav>
            <hr />
        </header>
    );
}

export default Header;
