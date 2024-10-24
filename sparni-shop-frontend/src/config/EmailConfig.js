import axios from 'axios';

const API_URL = 'http://localhost:8080/api/contact/client/email/save';

class UserService {
    postEmailSave(emailData) {
        return axios.post(API_URL, emailData);
    }
}

export default new UserService();
