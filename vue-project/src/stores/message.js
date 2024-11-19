import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_API_URL = `http://localhost:8080/api-message`;

export const useMessageStore = defineStore('message', () => {
  const message = ref(null);
  const getMessage = function(email, day) {
    axios({
      url: REST_API_URL + "/open/" + email + "/" + day,
      method: 'GET'
    })
    .then((response)=>{
      if(response.data !== '')
        message.value = response.data;
      else message.value = null;
    })
    .catch(()=>{
      console.log("사용자 이메일과 일차수로 메시지 가져오기 실패");
    })
  };

  return {
    message,
    getMessage,
  };
})
