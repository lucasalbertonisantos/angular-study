export interface Photo {
    id:number;
    url: string;
	description: string;
	postDate: Date;
	allowComments: boolean;
	number: number;
	comments: number;
	userId: number;
}