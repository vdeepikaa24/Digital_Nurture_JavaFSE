import axios from 'axios';
import GitClient from './GitClient';

jest.mock('axios');

test('should return repository names for techiesyed', async () => {
  const dummyData = {
    data: [{ name: 'repo1' }, { name: 'repo2' }]
  };
  
  axios.get.mockResolvedValue(dummyData);

  const result = await GitClient.getRepositories('techiesyed');
  
  expect(result.data).toEqual(dummyData.data);
  expect(axios.get).toHaveBeenCalledWith(
    'https://api.github.com/users/techiesyed/repos'
  );
});