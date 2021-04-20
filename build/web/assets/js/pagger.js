function pagger(paggerClass, parameterName, parameterValue, pageIndex, totalPages, gap) {
    const pagger = document.getElementsByClassName(paggerClass);
    for (let i = 0; i < pagger.length; i++) {
        const paggerEl = pagger[i];
        if (pageIndex - gap > 1) {
            const firstPagger = document.createElement('li');
            firstPagger.setAttribute('class', 'page-item');
            const firstPaggerLink = document.createElement('a');
            firstPaggerLink.setAttribute('class', 'page-link');
            firstPaggerLink.href = '?' + parameterName + '=' + parameterValue + '&page=1';
            firstPaggerLink.innerHTML = 'First';
            firstPagger.appendChild(firstPaggerLink);
            paggerEl.appendChild(firstPagger);
        }
        for (let j = pageIndex - gap; j < pageIndex; j++) {
            if (j > 0) {
                const numPagger = document.createElement('li');
                numPagger.setAttribute('class', 'page-item');
                const numPaggerLink = document.createElement('a');
                numPaggerLink.setAttribute('class', 'page-link');
                numPaggerLink.href = '?' + parameterName + '=' + parameterValue + '&page=' + j;
                numPaggerLink.innerHTML = j;
                numPagger.appendChild(numPaggerLink);
                paggerEl.appendChild(numPagger);
            }
        }
        const currentPagger = document.createElement('li');
        currentPagger.setAttribute('class', 'page-item active');
        const currentPaggerLink = document.createElement('a');
        currentPaggerLink.setAttribute('class', 'page-link');
        currentPaggerLink.innerHTML = pageIndex + '<span class="sr-only">(current)</span>';
        currentPagger.appendChild(currentPaggerLink);
        paggerEl.appendChild(currentPagger);
        for (let j = pageIndex + 1; j < pageIndex + gap + 1; j++) {
            if (j <= totalPages) {
                const numPagger = document.createElement('li');
                numPagger.setAttribute('class', 'page-item');
                const numPaggerLink = document.createElement('a');
                numPaggerLink.setAttribute('class', 'page-link');
                numPaggerLink.href = '?' + parameterName + '=' + parameterValue + '&page=' + j;
                numPaggerLink.innerHTML = j;
                numPagger.appendChild(numPaggerLink);
                paggerEl.appendChild(numPagger);
            }
        }
        if (pageIndex + gap < totalPages) {
            const lastPagger = document.createElement('li');
            lastPagger.setAttribute('class', 'page-item');
            const lastPaggerLink = document.createElement('a');
            lastPaggerLink.setAttribute('class', 'page-link');
            lastPaggerLink.href = '?' + parameterName + '=' + parameterValue + '&page=' + totalPages;
            lastPaggerLink.innerHTML = 'Last';
            lastPagger.appendChild(lastPaggerLink);
            paggerEl.appendChild(lastPagger);
        }
    }
}

function paggerBasic(paggerClass, pageIndex, totalPages, gap) {
    const pagger = document.getElementsByClassName(paggerClass);
    for (let i = 0; i < pagger.length; i++) {
        const paggerEl = pagger[i];
        if (pageIndex - gap > 1) {
            const firstPagger = document.createElement('li');
            firstPagger.setAttribute('class', 'page-item');
            const firstPaggerLink = document.createElement('a');
            firstPaggerLink.setAttribute('class', 'page-link');
            firstPaggerLink.href = '?page=1';
            firstPaggerLink.innerHTML = 'First';
            firstPagger.appendChild(firstPaggerLink);
            paggerEl.appendChild(firstPagger);
        }
        for (let j = pageIndex - gap; j < pageIndex; j++) {
            if (j > 0) {
                const numPagger = document.createElement('li');
                numPagger.setAttribute('class', 'page-item');
                const numPaggerLink = document.createElement('a');
                numPaggerLink.setAttribute('class', 'page-link');
                numPaggerLink.href = '?page=' + j;
                numPaggerLink.innerHTML = j;
                numPagger.appendChild(numPaggerLink);
                paggerEl.appendChild(numPagger);
            }
        }
        const currentPagger = document.createElement('li');
        currentPagger.setAttribute('class', 'page-item active');
        const currentPaggerLink = document.createElement('a');
        currentPaggerLink.setAttribute('class', 'page-link');
        currentPaggerLink.innerHTML = pageIndex + '<span class="sr-only">(current)</span>';
        currentPagger.appendChild(currentPaggerLink);
        paggerEl.appendChild(currentPagger);
        for (let j = pageIndex + 1; j < pageIndex + gap + 1; j++) {
            if (j <= totalPages) {
                const numPagger = document.createElement('li');
                numPagger.setAttribute('class', 'page-item');
                const numPaggerLink = document.createElement('a');
                numPaggerLink.setAttribute('class', 'page-link');
                numPaggerLink.href = '?page=' + j;
                numPaggerLink.innerHTML = j;
                numPagger.appendChild(numPaggerLink);
                paggerEl.appendChild(numPagger);
            }
        }
        if (pageIndex + gap < totalPages) {
            const lastPagger = document.createElement('li');
            lastPagger.setAttribute('class', 'page-item');
            const lastPaggerLink = document.createElement('a');
            lastPaggerLink.setAttribute('class', 'page-link');
            lastPaggerLink.href = '?page=' + totalPages;
            lastPaggerLink.innerHTML = 'Last';
            lastPagger.appendChild(lastPaggerLink);
            paggerEl.appendChild(lastPagger);
        }
    }
}