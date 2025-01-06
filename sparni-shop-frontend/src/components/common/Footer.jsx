import "../../static/css/Footer.css";
import { Link } from "react-router-dom";
import { useTranslation } from "react-i18next";
import phoneIcon from "../../static/img/icon-phone.png";
import emailIcon from "../../static/img/icon-email.png";
import facebookIcon from "../../static/img/icon-facebook.png";
import addressIcon from "../../static/img/icon-address.png";

function Footer() {
  const { t } = useTranslation();

  return (
    <footer>
      <div className="containericons">
        <nav>
          <Link to="/main">{t("nav.home")}</Link>
          <Link to="/store">{t("nav.store")}</Link>
          <Link to="/events">{t("nav.events")}</Link>
          <Link to="/info">{t("nav.info")}</Link>
          <Link to="/contact">{t("nav.contact")}</Link>
        </nav>
        <hr />

        <div className="footer-links">
          <ul>
            <li><Link to="/popular">{t("TOP preces")}</Link></li>
            <li><Link to="/categories">{t("Kategorijas")}</Link></li>
            <li><Link to="/payment">{t("Maksājumi")}</Link></li>
            <li><Link to="/returns">{t("Preču atgriešana")}</Link></li>
          </ul>
          <ul>
            <li><Link to="/delivery">{t("Piegāde")}</Link></li>
            <li><Link to="/about">{t("Par mums")}</Link></li>
            <li><Link to="/privacy">{t("Privātuma politika")}</Link></li>
            <li><Link to="/terms">{t("Noteikumi")}</Link></li>
          </ul>
        </div>

        
        <div className="icon-list">
          <ul>
            <li><img src={phoneIcon} alt="Phone Icon" /></li>
            <li><img src={emailIcon} alt="Email Icon" /></li>
            <li><img src={facebookIcon} alt="Facebook Icon" /></li>
            <li><img src={addressIcon} alt="Address Icon" /></li>
          </ul>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
