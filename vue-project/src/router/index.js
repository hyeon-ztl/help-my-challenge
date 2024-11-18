import { createRouter, createWebHistory } from 'vue-router'

import ChallengeView from '../views/ChallengeView.vue'

import SsafitView from '@/views/SsafitView.vue'
import YoutubeSearchResult from '@/components/youtube/YoutubeSearchResult.vue'
import YoutubeDetail from '@/components/youtube/YoutubeDetail.vue'
import GoalRegist from '@/components/goal/GoalRegist.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'ssafit',
      component: SsafitView,
      children: [
        {
          path: 'search-result',
          name: 'searchResult',
          component: YoutubeSearchResult
        },  
      ]
    },
    {
      path: '/detail',
      name: 'detail',
      component: YoutubeDetail
    },
    {
      path: '/challenge',
      name: 'challenge',
      component: ChallengeView,
    },
    {
      path: '/regist',
      name: 'goalRegist',
      component: GoalRegist,
    }
  ],
})

export default router
