
<template>
    <div>
        <header>
            <nav>
                <h1>SSAFIT</h1>
                <router-link :to="{name: 'ssafit'}" class="header-ssafit-main-btn">SSAFIT</router-link> |

                <!-- 챌린지 들어가면 챌린지 버튼 없어지기 비활성화 -->
                <router-link v-if="store.loginUser !== null && !hideChallenge" :to="{path: `/challenge/${store.loginUser.email}`}" class="challenge">CHALLENGE</router-link> |
                <div class="header-layout">
                    <img v-if="store.loginUser === null" @click="kakaoLogin" src="@/assets/kakao_login_medium_narrow.png" width="111" class="header-login-btn">
                    <div v-if="store.loginUser !== null">
                        <img :src="store.loginUser.profileImage" class="header-kakao-img">
                        <p class="header-login-word">{{ store.loginUser.nickname }}님 반갑습니다.</p>
                        <button @click="logout" class="header-login-btn">LOGOUT</button>
                    </div>
                </div>
            </nav>
        </header>

        <router-view></router-view>
    </div>
</template>

<script setup>
    import { defineProps } from 'vue';
    import { RouterLink, RouterView } from 'vue-router';
    import { useUserStore } from '@/stores/user';
    const store = useUserStore();

    const logout = function() {
        store.logout();
    }

    const kakaoLogin = function() {
        store.kakaoLogin();
    }

    // App.vue에서 내려준 hideChallenge, isMain 상태를 받아옵니다.
    defineProps({
    hideChallenge: {
    type: Boolean,
    default: false,
    },

    // Main인지 확인하는 변수
    isMain:{
        type:Boolean,
        default: true,
    },
    });

</script>

<style scoped>

</style>
