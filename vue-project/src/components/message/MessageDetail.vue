<template>
    <div>
        detail 화면
        <!-- <p>
            From. {{ store.messages[route.params.day].senderNickname }}
        </p>
        <p>
            {{ store.messages[route.params.day].content }}
        </p>
        <p v-if="userStore.loginUser.email === store.messages[route.params.day].sender">
            <button>수정</button>
        </p> -->
        
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import { useMessageStore } from '@/stores/message';
import { useUserStore } from '@/stores/user';

const route = useRoute(); // 현재 라우트 정보
const store = useMessageStore(); // Pinia 메시지 스토어
const userStore = useUserStore();

const props = defineProps({
    message: Object,
});

</script>

<style scoped>
/* 필요에 따라 스타일 추가 */
</style>
