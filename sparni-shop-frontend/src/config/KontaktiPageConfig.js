// UserService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/kontakti';

class UserService {
    getAllKontakti() {
        return axios.get(API_URL);
    }
}

export default new UserService();
