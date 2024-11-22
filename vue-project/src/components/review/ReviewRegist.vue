<template>
    <div>
        <fieldset>
            <div class="regist-input-box" @click="scrollToInput">
                <textarea
                    id="content"
                    v-model="review.content"
                    rows="5"
                    cols="30"
                    maxlength="200"
                    class="regist-input-realbox"
                    @keyup.enter="registReview"
                ></textarea>
                <p>{{ review.content.length }}/200</p>
            </div>
            <div>
                <button @click="registReview" class="regist-input-btn">등록</button>
            </div>
        </fieldset>
    </div>
</template>


<script setup>
import { ref, watch } from 'vue';
import { useReviewStore } from '@/stores/review';
import { useUserStore } from '@/stores/user';

const store = useReviewStore();
const userStore = useUserStore();

const props = defineProps({
    videoId: String,
});

watch(() => props.videoId, (newVideoId) => {
    review.value.videoId = newVideoId;
});

const review = ref({
    email: userStore.loginUser.email,
    nickname: userStore.loginUser.nickname,
    videoId: props.videoId,
    content: '',
});

const registReview = function () {
    console.log(review.value);
    store.registReview(props.videoId, review.value);
    review.value.content = '';
};

// 입력창 활성화 시 스크롤 최상단 이동 함수
const scrollToInput = function () {
    const inputBox = document.getElementById('content');
    if (inputBox) {
        inputBox.scrollIntoView({ behavior: 'smooth', block: 'start' });
    }
};
</script>

<style scoped></style>