// UserService.js
import axios from 'axios';

const API_URL = 'http://localhost:8081/pasakumi/all';

class UserService {
    getAllPasakumi() {
        return axios.get(API_URL);
    }
}

export default new UserService();
