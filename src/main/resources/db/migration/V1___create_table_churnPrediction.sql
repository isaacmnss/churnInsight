CREATE TABLE previsao_churn (
    id BIGSERIAL PRIMARY KEY,

    credit_score INTEGER NOT NULL,
    geography VARCHAR(100) NOT NULL,
    gender VARCHAR(20) NOT NULL,
    age INTEGER NOT NULL,
    tenure INTEGER NOT NULL,

    balance DOUBLE PRECISION NOT NULL,
    num_of_products INTEGER NOT NULL,
    has_cr_card BOOLEAN NOT NULL,
    is_active_member BOOLEAN NOT NULL,
    estimated_salary DOUBLE PRECISION NOT NULL,

    point_earned INTEGER NOT NULL,
    card_type VARCHAR(50) NOT NULL,

    churn_probability DOUBLE PRECISION NOT NULL,
    churn BOOLEAN NOT NULL,

    created_at TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW()
);