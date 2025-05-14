import type { User } from "./User";

export interface Post {
    likes: number;
    details: string;
    user: User;
}
