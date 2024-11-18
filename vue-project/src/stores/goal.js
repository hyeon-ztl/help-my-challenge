import { ref, computed } from 'vue'
import { defineStore } from 'pinia'
import axios from 'axios'
import router from '@/router'

const REST_API_URL = `http://localhost:8080/api-goal/goal`;

export const useGoalStore = defineStore('goal', () => {
  const goal = ref(null);
  const getGoal = function(userEmail) {
    axios({
      url: REST_API_URL + "/" + userEmail,
      method: 'GET'
    })
    .then((response)=>{
      console.log(response.data);
      goal.value = response.data;
      sessionStorage.setItem('goal', JSON.stringify(goal.value));
    })
    .catch(()=>{
      console.log("사용자 goal 가져오기 에러 발생")
    })
  };

  const registGoal = function(goal) {
    axios({
      url: REST_API_URL,
      method: 'POST',
      data: goal
    })
    .then(()=>{
      router.push({name: 'challenge'});
    })
    .catch(()=>{
      console.log("등록 에러 발생")
    })
  }

  return {
    goal,
    getGoal,
    registGoal,
  };
})
