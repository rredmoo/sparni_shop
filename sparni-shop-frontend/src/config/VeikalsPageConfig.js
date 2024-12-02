import API from '../Api'; 

class UserService {
    getAllPreces() {
        return API.get('/veikals/all');
    }

    getPrecesOrderedByAsc() {
        return API.get('/veikals/price/asc');
    }
    
    getPrecesOrderedByDesc() {
        return API.get('/veikals/price/desc');
    }
}

export default new UserService();
