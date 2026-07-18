import React from 'react';
import { mount, shallow } from 'enzyme';
import CohortDetails from './CohortDetails'; 
import { CohortData } from './Cohort';      

describe("Cohort Details Component", () => {
    
    // Test 1: Verify the component loads in isolation
    test("should create the component", () => {
        const wrapper = shallow(<CohortDetails />);
        expect(wrapper.exists()).toBe(true);
    });

    // Test 2: Verify props initialization
    test("should initialize the props", () => {
        const testData = CohortData[0];
        const wrapper = mount(<CohortDetails cohort={testData} />);
        expect(wrapper.prop('cohort')).toEqual(testData);
    });

    // Test 3: Verify the cohort code is displayed in an <h3> element
    test("should display cohort code in h3", () => {
        const testData = CohortData[0];
        const wrapper = mount(<CohortDetails cohort={testData} />);
        // Ensure your CohortDetails.js renders the code inside <h3>
        expect(wrapper.find('h3').text()).toBe(testData.cohortCode);
    });

    // Test 4: Capture a snapshot for rendering consistency
    test("should always render same html", () => {
        const wrapper = shallow(<CohortDetails cohort={CohortData[0]} />);
        expect(wrapper).toMatchSnapshot();
    });

});