import "../../static/css/Footer.css";
import { Link } from "react-router-dom";
import { useTranslation } from "react-i18next";

function Footer() {
  const { t } = useTranslation();

  return (
    <footer>
      <div className="container">
        <nav>
          <Link to="/main">{t("nav.home")}</Link>
          <Link to="/store">{t("nav.store")}</Link>
          <Link to="/events">{t("nav.events")}</Link>
          <Link to="/info">{t("nav.info")}</Link>
          <Link to="/contact">{t("nav.contact")}</Link>
        </nav>
        <hr />

        <div className="icon-list">
          <ul>
            <li><img src="/path-to-icon1.png" alt="Icon 1" /></li>
            <li><img src="/path-to-icon2.png" alt="Icon 2" /></li>
            <li><img src="/path-to-icon3.png" alt="Icon 3" /></li>
            <li><img src="/path-to-icon4.png" alt="Icon 4" /></li>
            <li><img src="/path-to-icon5.png" alt="Icon 5" /></li>
          </ul>
        </div>

        <div className="footer-links">
          <ul>
            <li><Link to="/popular">{t("footer.popular")}</Link></li>
            <li><Link to="/categories">{t("footer.categories")}</Link></li>
            <li><Link to="/payment">{t("footer.payment")}</Link></li>
            <li><Link to="/returns">{t("footer.returns")}</Link></li>
            <li><Link to="/delivery">{t("footer.delivery")}</Link></li>
            <li><Link to="/about">{t("footer.about")}</Link></li>
          </ul>
        </div>
      </div>
    </footer>
  );
}

export default Footer;