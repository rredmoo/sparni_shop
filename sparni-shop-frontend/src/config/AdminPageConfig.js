import axios from 'axios';

const BASE_URL = 'http://localhost:8081/api/contact';

const getAllEmails = () => {
    return axios.get(`${BASE_URL}/all`);
};

const searchEmailsByUserName = (username) => {
    return axios.get(`${BASE_URL}/username/${username}`);
};

const searchEmailsByTopic = (topic) => {
    return axios.get(`${BASE_URL}/topic/${topic}`);
};

const searchEmailsByEmail = (email) => {
    return axios.get(`${BASE_URL}/email/${email}`);
};

const EmailServiceConfig = {
    getAllEmails,
    searchEmailsByUserName,
    searchEmailsByEmail,
};

export default EmailServiceConfig;
