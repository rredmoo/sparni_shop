// UserService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/veikals/all';

class UserService {
    getAllPreces() {
        return axios.get(API_URL);
    }
}

export default new UserService();
