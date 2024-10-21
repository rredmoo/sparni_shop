import axios from 'axios';

const API_URL = 'http://localhost:8080/api/contact/all';

const getAllEmails = () => {
    return axios.get(API_URL);
};

const EmailServiceConfig = {
    getAllEmails,
};

export default EmailServiceConfig;
