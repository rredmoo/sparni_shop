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

    updateProduct(id, product) {
        return API.put(`/veikals/prece/${id}`, product);
      }
}

export default new UserService();
