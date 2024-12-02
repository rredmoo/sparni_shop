import API from '../Api';
class UserService {
    postEmailSave(emailData) {
        return API.post('/api/contact/client/email/save', emailData);
    }
}

export default new UserService();
