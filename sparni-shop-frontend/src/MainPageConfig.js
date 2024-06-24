// UserService.js
import axios from 'axios';

const API_URL = 'http://localhost:8080/veikals/all';

class UserService {
    getAllAtlaide() {
        return axios.get(API_URL);
    }
}

export default new UserService();
