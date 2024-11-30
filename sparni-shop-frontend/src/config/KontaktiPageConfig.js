import API from '../Api';

class UserService {
    getAllKontakti() {
        return API.get('/kontakti/all');
    }
}

export default new UserService();
