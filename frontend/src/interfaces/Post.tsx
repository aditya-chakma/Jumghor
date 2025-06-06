import type { User } from "./User";

export interface Post {
    id: string,
    likes: number;
    details: string;
    user: User;
}
