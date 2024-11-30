import API from '../Api';

class UserService {
    getAllInformacija() {
        return API.get('/informacija/all');
    }
}

export default new UserService();
