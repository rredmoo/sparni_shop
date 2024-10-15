import "../../static/css/Footer.css";
import { Link } from "react-router-dom";
import { useTranslation } from "react-i18next"; 

function Footer() {
  const { t } = useTranslation(); 

  return (
    <>
      <footer>
        <div className="container">
          <nav>

          <Link to="/main">{t('nav.home')}</Link>
          <Link to="/store">{t('nav.store')}</Link>
          <Link to="/events">{t('nav.events')}</Link>
          <Link to="/info">{t('nav.info')}</Link>
          <Link to="/contact">{t('nav.contact')}</Link>

          </nav>
          <hr />
          <p className="note">
            {t('contactUs')}
          </p>
        </div>
      </footer>
    </>
  );
}

export default Footer;
