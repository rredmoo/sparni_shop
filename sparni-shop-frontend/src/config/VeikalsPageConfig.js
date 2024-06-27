import axios from 'axios';

const API_URL1 = 'http://localhost:8080/veikals/all';
const API_URL2 = 'http://localhost:8080/veikals/top';

class UserService {
    getAllPreces() {
        return axios.get(API_URL1);
    }

    getTopPreces() {
        return axios.get(API_URL2);
    }
}


export default new UserService();
