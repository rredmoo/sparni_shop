import API from '../Api';
class UserService {
    postEmailSave(emailData) {
        return API.post('/api/contact/client/email/save', emailData);
    }

    getSavedEmails(){
        return API.get('/api/contact/show-all-client-emails');
    }
}

export default new UserService();
