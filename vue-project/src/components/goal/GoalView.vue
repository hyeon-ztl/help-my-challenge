<template>
    <div>
        <!-- 목표가 있는 경우 목표 보여주기 -->
        <div v-if="store.goal">
            <p v-if="diff < 0">{{ store.goal.name }}님 운동 시작 {{ -diff }}일 전</p>
            <p v-if="diff > 0">{{ store.goal.name }}님 운동 시작 {{ diff }}일차</p>
            <div>
                <p>{{store.goal.goalName}} {{ store.goal.goalDescription }}</p>
                <p>{{ store.goal.startDate }} 시작</p>
            </div>
            <div>
                <p>challenge</p>
                <p>{{ store.goal.day }}일 도전</p>
            </div>
            <div>
            <p>실패 공약</p>
            <p>{{ store.goal.pledge }}</p>
            </div>
            <div>
                <p>{{ store.goal.name }}의 한마디</p>
                <p>{{ store.goal.text }}</p>
                <div v-if="userStore.loginUser !== null">
                    <button @click="goalTextUpdateModalToggle" v-if="userStore.loginUser.email === route.params.email">한마디수정</button>
                
                    <div class="modal-wrap" v-show="goalTextUpdateModal">
                    <div class="modal-container">
                            <GoalUpdateText/>
                        <div class="modal-btn">
                            <button @click="goalTextUpdateModalToggle" class="modal-close-btn">X</button>
                        </div>
                    </div>
                    </div>
                </div>
            </div>

            <!-- 목표 시작 이전 목표 수정 가능 -->
            <div v-if="new Date() < new Date(store.goal.startDate)">
                <button @click="goalModalToggle" v-if="userStore.loginUser.email === route.params.email">목표수정하기</button>
                
                <div class="modal-wrap" v-show="goalModal">
                <div class="modal-container">
                        <GoalUpdate/>
                    <div class="modal-btn">
                        <button @click="goalModalToggle" class="modal-close-btn">X</button>
                    </div>
                </div>
                </div> 
            </div>

            <!-- 목표 시작 이후 목표 삭제만 가능 -->
            <div v-if="new Date() > new Date(store.goal.startDate)">
                <button @click="goalModalToggle" v-if="userStore.loginUser && userStore.loginUser.email === route.params.email">목표삭제하기</button>
                
                <div class="modal-wrap" v-show="goalModal">
                <div class="modal-container">
                        <GoalDelete @close-modal="goalModalToggle"/>
                    <div class="modal-btn">
                        <button @click="goalModalToggle" class="modal-close-btn">X</button>
                    </div>
                </div>
                </div> 
            </div>
        </div>

        <!-- 목표가 없는 경우 등록 창 보여주기 -->
        <div v-if="!store.goal">
            <div>
                <p>목표를 등록해주세요.</p>
            </div>
            <div>
                <p>challenge</p>
                <p>목표를 등록해주세요.</p>
            </div>
            <div>
                <p>실패 공약</p>
                <p>공약을 등록해주세요</p>
            </div>
            <div>
                <p>한마디</p>
                <p>한마디를 등록해주세요.</p>
            </div>

            <div>
                <button @click="goalRegistModalToggle">등록</button>
            </div>

            <!-- 등록 컴포넌트 모달 -->
            <div class="modal-wrap" v-show="goalRegistModal">
            <div class="modal-container">
                    <GoalRegist @open-confirm-modal="openConfirmModal"/>
                <div class="modal-btn">
                    <button @click="goalRegistModalToggle" class="modal-close-btn">X</button>
                </div>
            </div>
            </div>

            <!-- 목표 등록 시 확인 -->
            <div class="modal-wrap" v-show="confirmModal">
            <div class="modal-container">
                <div class="modal-background">
                    <p class="modal-alarm">목표 시작일 이전까지만 수정이 가능합니다.</p>
                    <p class="modal-alarm">등록하시겠습니까?</p>
                    <div id="modal-alarm-btns">
                        <button @click="registGoal" class="modal-regist-btn">확인</button>
                        <button @click="closeConfirmModal" class="modal-regist-btn" id="modal-alarm-btns-cancel">취소</button>
                    </div>
                </div>
                <div class="modal-btn">
                    <button @click="closeConfirmModal" class="modal-close-btn">X</button>
                </div>
            </div>
            </div>
        </div>

    </div>
</template>

<script setup>
import { ref, onMounted, computed } from 'vue';
import { useRoute } from 'vue-router';
import { useGoalStore } from '@/stores/goal';
import { useUserStore } from '@/stores/user';

import GoalRegist from './GoalRegist.vue';
import GoalUpdateText from './GoalUpdateText.vue';
import GoalUpdate from './GoalUpdate.vue';
import GoalDelete from './GoalDelete.vue';

const store = useGoalStore();
const userStore = useUserStore();
const route = useRoute();

const props = defineProps({
    email: String,
})

onMounted(() => {
  store.getGoal(route.params.email);
});

const diff = computed(() => {
  const today = new Date();
  const start = new Date(store.goal?.startDate);

  const diffInMilliseconds = today - start;
  return Math.floor(diffInMilliseconds / (1000 * 60 * 60 * 24));
});

// 목표 등록 모달
const goalRegistModal = ref(false);
const goalRegistModalToggle = function() {
    goalRegistModal.value = !goalRegistModal.value;
}

const goalToRegist = ref(null);
const registGoal = function() {
    store.registGoal(goalToRegist.value);
}

const confirmModal = ref(false); // 등록 확인용
const openConfirmModal = function(goal) {
    goalRegistModalToggle();
    confirmModal.value = !confirmModal.value;
    goalToRegist.value = goal;
}
const closeConfirmModal = function() {
    confirmModal.value = !confirmModal.value;
}

// 한마디 수정 모달
const goalTextUpdateModal = ref(false);
const goalTextUpdateModalToggle = function() {
    goalTextUpdateModal.value = !goalTextUpdateModal.value;
};

// 공통 모달
const goalModal = ref(false);
const goalModalToggle = function() {
    goalModal.value = !goalModal.value;
};


</script>

<style scoped>
</style>