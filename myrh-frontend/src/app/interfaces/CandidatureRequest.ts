export interface CandidatureRequest {
    offerId: string;
    fullname: string;
    email: string;
    phone: string;
    cv: File | null;
    coverLetter: string;
}
