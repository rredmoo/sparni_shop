import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import "./AdminPanel.css";
import EmailServiceConfig from "../../config/AdminPageConfig";
import SendBulkEmail from "./SendBulkEmail";
import SendSelectedEmail from "./SendSelectedEmail";
import productServiceapi from "../../config/VeikalsPageConfig";

const AdminPanel = () => {
  const [epastiNoKlientiem, setEpastiNoKlientiem] = useState([]); // emails
  const [filteredEpasti, setFilteredEpasti] = useState([]);       // filtered emails
  const [searchQuery, setSearchQuery] = useState("");             // search query
  const [expandedRows, setExpandedRows] = useState([]);           // expanded rows for email details
  const [error, setError] = useState(null);
  const [products, setProducts] = useState([]);                   // state to store products
  const [currentPage, setCurrentPage] = useState(1);              // current page for pagination
  const itemsPerPage = 5;                                         // items per page
  const navigate = useNavigate();

  const handleLogout = () => {
    localStorage.removeItem("isAuthenticated");
    navigate("/main");
  };

  const toggleRow = (id) => {
    if (expandedRows.includes(id)) {
      setExpandedRows(expandedRows.filter((rowId) => rowId !== id));
    } else {
      setExpandedRows([...expandedRows, id]);
    }
  };

  const isRowExpanded = (id) => expandedRows.includes(id);

  const truncateText = (text, wordLimit = 20) => {
    const words = text.split(" ");
    if (words.length > wordLimit) {
      return words.slice(0, wordLimit).join(" ") + "...";
    }
    return text;
  };


  const paginateEmails = (emails) => {
    const startIndex = (currentPage - 1) * itemsPerPage;
    const endIndex = currentPage * itemsPerPage;
    return emails.slice(startIndex, endIndex);
  };

  const paginateProducts = (products) => {
    const startIndex = (currentPage - 1) * itemsPerPage;
    const endIndex = currentPage * itemsPerPage;
    return products.slice(startIndex, endIndex);
  };

  const handlePageChange = (page) => {
    const totalPages = Math.ceil(products.length / itemsPerPage);

    // Ensure the page is within valid bounds
    if (page >= 1 && page <= totalPages) {
      setCurrentPage(page);
    }
  };

  const totalPages = Math.ceil(products.length / itemsPerPage);

  useEffect(() => {
    const fetchEmails = async () => {
      try {
        const response = await EmailServiceConfig.getAllEmails();
        if (Array.isArray(response.data)) {
          setEpastiNoKlientiem(response.data);
          setFilteredEpasti(response.data); 
        } else {
          console.error("Expected an array but got:", response.data);
          setEpastiNoKlientiem([]);
        }
      } catch (error) {
        console.error("Error fetching emails", error);
        setError(error.message);
      }
    };
    fetchEmails();
  }, []);

  useEffect(() => {
    const fetchProducts = async () => {
      try {
        const response = await productServiceapi.getAllPreces();
        console.log("Fetched Products:", response.data); 
        if (Array.isArray(response.data)) {
          setProducts(response.data);
        } else {
          console.error("Expected an array but got:", response.data);
          setProducts([]);
        }
      } catch (error) {
        console.error("Error fetching products", error);
        setError(error.message);
      }
    };
    fetchProducts();
  }, []);

  useEffect(() => {
    const filtered = epastiNoKlientiem.filter(
      (email) =>
        email.userName.toLowerCase().includes(searchQuery.toLowerCase()) ||
        email.userEmail.toLowerCase().includes(searchQuery.toLowerCase()) ||
        email.topic.toLowerCase().includes(searchQuery.toLowerCase()) ||
        email.messageContent.toLowerCase().includes(searchQuery.toLowerCase())
    );
    setFilteredEpasti(filtered);
  }, [searchQuery, epastiNoKlientiem]);

  const totalPagesEmails = Math.ceil(filteredEpasti.length / itemsPerPage);
  const totalPagesProducts = Math.ceil(products.length / itemsPerPage);

  return (
    <div className="admin-panel">
      <nav className="sidebar">
        <h2 className="logo">Spārni Admin</h2>
        <ul className="menu">
          <li>
            <a href="#">Dashboard</a>
          </li>
          <li>
            <a href="#">Products</a>
          </li>
          <li>
            <a href="#">Orders</a>
          </li>
          <li>
            <a href="#">Customers</a>
          </li>
          <li>
            <a href="#">Settings</a>
          </li>
          <li>
            <button className="logout-button" onClick={handleLogout}>
              Log Out
            </button>
          </li>
        </ul>
      </nav>
      <main className="main-content">
        <header className="header">
          <h1>Sveiks, Admin</h1>
          <p>Veikala pārvaldīšanas panelis</p>
        </header>

        {/* Search Section */}
        <section>
          <h3>Search Emails</h3>
          <input
            className="searchInput"
            type="text"
            placeholder="Search by username, email, topic, or message"
            value={searchQuery}
            onChange={(e) => setSearchQuery(e.target.value)} // Update search
          />
        </section>

        {/* Emails Section */}
        <section>
          <h3>Epasti no klientiem</h3>
          {error && <p>Error: {error}</p>}
          <table className="email-table">
            <thead>
              <tr>
                <th>Username</th>
                <th>Email</th>
                <th>Topic</th>
                <th>Message</th>
                <th>Received At</th>
              </tr>
            </thead>
            <tbody>
              {filteredEpasti.length > 0 ? (
                paginateEmails(filteredEpasti).map((email) => (
                  <tr
                    key={email.idenk}
                    onClick={() => toggleRow(email.idenk)}
                    className="clickable-row"
                  >
                    <td>{email.userName}</td>
                    <td>{email.userEmail}</td>
                    <td>{email.topic}</td>
                    <td>
                      {isRowExpanded(email.idenk)
                        ? email.messageContent
                        : truncateText(email.messageContent)}
                    </td>
                    <td>{new Date(email.receivedAt).toLocaleString()}</td>
                  </tr>
                ))
              ) : (
                <tr>
                  <td colSpan="5">No emails available</td>
                </tr>
              )}
            </tbody>
          </table>

          {/* Pagination Controls for Emails */}
          <div className="pagination">
            <button
              onClick={() => handlePageChange(currentPage - 1)}
              disabled={currentPage === 1}
            >
              Prev
            </button>
            <span>
              Page {currentPage} of {totalPagesEmails}
            </span>
            <button
              onClick={() => handlePageChange(currentPage + 1)}
              disabled={currentPage === totalPagesEmails}
            >
              Next
            </button>
          </div>
        </section>

        {/* Products Section */}
        <section>
          <h3>Products</h3>
          <div className="admin-product-list">
            {paginateProducts(products).map((product) => (
              <div key={product.productId} className="admin-product-card">
                <img
                  src={product.veikals_prece_bildes}
                  alt={product.name}
                  className="admin-product-card-img"
                />
                <div className="admin-product-card-details">
                  <h4>{product.name}</h4>
                  <p>{product.description}</p>
                  <p className="admin-product-card-price">${product.price}</p>
                </div>
                <div className="admin-product-card-actions">
                  <button>Edit</button>
                </div>
              </div>
            ))}
          </div>

          {/* Pagination Controls for Products */}
          <div className="admin-product-pagination">
            <button
              onClick={() => handlePageChange(currentPage - 1)}
              disabled={currentPage === 1 || products.length === 0}
            >
              Prev
            </button>
            <span>
              Page {currentPage} of {totalPagesProducts}
            </span>
            <button
              onClick={() => handlePageChange(currentPage + 1)}
              disabled={
                currentPage === totalPagesProducts || products.length === 0
              }
            >
              Next
            </button>
          </div>
        </section>

        {/* Bulk and Selected Email Sending Sections */}
        <br />
        <h1>Bulk Email</h1>
        <SendBulkEmail />

        <h1>Selected Email</h1>
        <SendSelectedEmail />
      </main>
    </div>
  );
};

export default AdminPanel;
