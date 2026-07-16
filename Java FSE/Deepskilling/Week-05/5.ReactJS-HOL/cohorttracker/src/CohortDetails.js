import React from 'react';
// 1. Import the CSS module
import styles from './CohortDetails.module.css';

function CohortDetails(props) {
    // 2. Define the conditional style for the h3
    const headerStyle = {
        color: props.cohort.currentStatus === 'Ongoing' ? 'green' : 'blue'
    };

    return (
        // 3. Apply the 'box' class from your CSS module
        <div className={styles.box}>
            <h3 style={headerStyle}>
                {props.cohort.cohortCode} - <span>{props.cohort.technology}</span>
            </h3>
            <dl>
                <dt>Started On</dt>
                <dd>{props.cohort.startDate}</dd>
                <dt>Current Status</dt>
                <dd>{props.cohort.currentStatus}</dd>
                <dt>Coach</dt>
                <dd>{props.cohort.coachName}</dd>
                <dt>Trainer</dt>
                <dd>{props.cohort.trainerName}</dd>
            </dl>
        </div>
    );
}

export default CohortDetails;