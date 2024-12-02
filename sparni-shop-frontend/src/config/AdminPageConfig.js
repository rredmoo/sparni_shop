import API from '../Api';

const getAllEmails = () => {
    return API.get('/all'); 
};

const searchEmailsByUserName = (username) => {
    return API.get(`/username/${username}`);
};

const searchEmailsByTopic = (topic) => {
    return API.get(`/topic/${topic}`);
};

const searchEmailsByEmail = (email) => {
    return API.get(`/email/${email}`);
};

const EmailServiceConfig = {
    getAllEmails,
    searchEmailsByUserName,
    searchEmailsByTopic,
    searchEmailsByEmail,
};

export default EmailServiceConfig;
