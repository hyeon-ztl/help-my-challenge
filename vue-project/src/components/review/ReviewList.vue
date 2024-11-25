<template>
    <hr class="thin-divider">
    <div>
        <p class="font-apple-semi-bold">리뷰 {{ store.reviewCount }}</p>
        <div v-if="store.reviewCount > 0">
            <div>
                <div v-for="review in store.reviewList" :key="review.reviewId">
                    <div>{{ review.nickname }}</div>
                    <div v-if="updateReviewId !== review.reviewId"> 
                        {{ review.content }}
                        {{ review.registDay }}
                        <button v-if="userStore.loginUser && userStore.loginUser.email === review.email"
                            @click="updateMode(review.reviewId)">수정</button>
                        <button v-if="userStore.loginUser && userStore.loginUser.email === review.email" 
                            @click="removeReview(review.reviewId)">삭제</button>
                    </div>
                    <div v-if="updateReviewId === review.reviewId">
                        <input type="text" v-model="store.review.content">
                        <button @click="updateReview">저장</button>
                        <button @click="updateReviewId = ''">취소</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script setup>
    import { onMounted, ref, watch } from 'vue';
    import { useReviewStore } from '@/stores/review';
    import { useUserStore } from '@/stores/user';

    const store = useReviewStore();
    const userStore = useUserStore();

    const props = defineProps({
        videoId: String,
    });

    watch(()=>props.videoId, (newVideoId)=>{
        if(newVideoId) {
            store.getReviewList(newVideoId);
        }
    });

    onMounted(()=>{
        store.getReviewList(props.videoId);
    });

    const updateReviewId = ref('');
    const updateMode = function(reviewId) {
        updateReviewId.value = reviewId;
        store.getReviewByReviewId(reviewId);
    }

    const updateReview = function() {
        updateReviewId.value = '';
        store.updateReview();
    }

    const removeReview = function(reviewId) {
        store.removeReview(props.videoId, reviewId);
    }
   
</script>

<style scoped>

</style>