import axios from 'axios';

const API_URL = 'http://localhost:8080/informacija/all';

class UserService {
    getAllInformacija() {
        return axios.get(API_URL);
    }
}

export default new UserService();
