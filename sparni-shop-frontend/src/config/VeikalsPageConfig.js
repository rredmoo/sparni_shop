import axios from 'axios';

const API_URL1 = 'http://localhost:8081/veikals/all';
const API_URL2 = 'http://localhost:8081/veikals/price/asc';
const API_URL3 = 'http://localhost:8081/veikals/price/desc';

class UserService {
    getAllPreces() {
        return axios.get(API_URL1);
    }

    getPrecesOrderedByAsc() {
        return axios.get(API_URL2);
    }
    
    getPrecesOrderedByDesc() {
        return axios.get(API_URL3);
    }
}


export default new UserService();
